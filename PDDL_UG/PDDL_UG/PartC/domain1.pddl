(define (domain windfarm-1)
    (:requirements :strips :typing :negative-preconditions)

    ; -------------------------------
    ; Types
    ; -------------------------------

    (:types
        Ship
        UUV
        Waypoint
        Data
        Sample
        Engineer
        ShipBay
        ShipControl
    )

    ; -------------------------------
    ; Predicates
    ; -------------------------------

    (:predicates
        (robotAt ?u - UUV ?w - Waypoint)
        (hasData ?u - UUV ?d - Data)
        (hasSample ?u - UUV ?s - Sample)

        (path ?a - Waypoint ?b - Waypoint)
        (shipPath ?a - Waypoint ?b - Waypoint)

        (shipSample ?f - Ship ?s - Sample)
        (shipData ?f - Ship ?d - Data)
        (shipLocation ?f - Ship ?w - Waypoint)

        (DataLocation ?d - Data ?w - Waypoint)
        (SampleLocation ?s - Sample ?w - Waypoint)

        (EngineerLocation ?e - Engineer ?m)
        (shipHasEngineer ?e - Engineer ?f - Ship)
    )

    ; -------------------------------
    ; Actions
    ; -------------------------------

    (:action ShipBayDoors
        :parameters (?m - ShipBay ?u - UUV ?e - Engineer ?f - Ship ?a - Waypoint ?b - Waypoint)
        :precondition (and
            (shipHasEngineer ?f ?e)
            (EngineerLocation ?e ?m)
            (robotAt ?u ?a)
            (shipLocation ?f ?a)
            (shipPath ?a ?b)
        )
        :effect (and
            (not(robotAt ?u ?a))
            (robotAt ?u ?b)
        )
    )

    (:action EngineerMoves
        :parameters (?m ?e - Engineer ?f - Ship ?l)
        :precondition (and
           (EngineerLocation ?e ?f ?m)
        )
        :effect (and
            (not(EngineerLocation ?e ?f ?m))
            (EngineerLocation ?e ?f ?l)
        )
    )

    (:action moveTo
        :parameters (?f - Ship ?a - Waypoint ?b - Waypoint ?u - UUV )
        :precondition (and
            (robotAt ?u ?a)
            (path ?a ?b)
            (not (shipLocation ?f ?b))
        )
        :effect (and
            (not(robotAt ?u ?a))
            (robotAt ?u ?b)
        )
    )

    (:action collectSample
        :parameters (?s - Sample ?w - Waypoint ?u - UUV)
        :precondition (and
            ; Commented out because I am unsure if a UUV can hold
            ; more than one sample at a time. Not clarified in restrictions
            ; Thus I will assume it can but just in case this would fix that.
            ;
            ;(not
            ;    (exists (?s - Sample)(hasSample ?u ?s))
            ;)
            (robotAt ?u ?w)
            (SampleLocation ?s ?w)
        )
        :effect (and
            (hasSample ?u ?s)
            (not (SampleLocation ?s ?w))
        )
    )

    (:action collectData
        :parameters (?d - Data ?w - Waypoint ?u - UUV)
        :precondition (and
            (not
                (exists
                    (?d - Data)
                    (hasData ?u ?d))
                ;Ensures that UUVs can only hold 1 piece of data
            )
            (robotAt ?u ?w)
            (DataLocation ?d ?w)
        )
        :effect (and
            (hasData ?u ?d)
            (not (DataLocation ?d ?w))
        )
    )

    (:action sendData
        :parameters (?e - Engineer ?f - Ship ?m - ShipControl ?d - Data ?u - UUV)
        :precondition (and
            (hasData ?u ?d)
            (EngineerLocation ?e ?f ?m)
        )
        :effect (and
            (not (hasData ?u ?d))
            (shipData ?f ?d)
        )
    )

    (:action offloadSample
        :parameters (?s - Sample ?w - Waypoint ?f - Ship ?u - UUV)
        :precondition (and
            (not
                (exists
                    (?s - Sample)
                    (shipSample ?f ?s))
                ;Ensures that Ships can only hold 1 sample
            )
            (robotAt ?u ?w)
            (shipLocation ?f ?w)
            (hasSample ?u ?s)
        )
        :effect (and
            (not (hasSample ?u ?s))
            (shipSample ?f ?s)
        )
    )

)