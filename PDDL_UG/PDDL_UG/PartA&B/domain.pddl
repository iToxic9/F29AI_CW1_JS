(define (domain windfarm)
    (:requirements :strips :typing :negative-preconditions)

    ; -------------------------------
    ; Types
    ; -------------------------------
    ; Important to note that Fast Downward does not work with types

    (:types
        Ship
        UUV
        Waypoint
        Data
        Sample
    )

    ; -------------------------------
    ; Predicates
    ; -------------------------------

    (:predicates
        (robotAt ?u - UUV ?w - Waypoint)
        (hasData ?u - UUV ?d - Data)
        (hasSample ?u - UUV ?s - Sample)

        (path ?a - Waypoint ?b - Waypoint)

        (shipSample ?f - Ship ?s - Sample)
        (shipData ?f - Ship ?d - Data) 
        (shipLocation ?f - Ship ?w - Waypoint)

        (DataLocation ?d - Data ?w - Waypoint)
        (SampleLocation ?s - Sample ?w - Waypoint)
    )

    ; -------------------------------
    ; Actions
    ; -------------------------------

    (:action moveTo
        :parameters 
            (?a - Waypoint ?b - Waypoint ?u - UUV)
        :precondition 
            (and
                (robotAt ?u ?a)
                (path ?a ?b)
            )
        :effect 
            (and
                (not(robotAt ?u ?a))
                (robotAt ?u ?b)
            )
    )

    (:action collectSample
        :parameters (?s - Sample ?w - Waypoint ?u - UUV)
        :precondition 
        (and
            (robotAt ?u ?w)
            (SampleLocation ?s ?w)
        )
        :effect 
        (and
            (hasSample ?u ?s)
            (not (SampleLocation ?s ?w))
        )
    )

    (:action collectData
        :parameters (?d - Data ?w - Waypoint ?u - UUV)
        :precondition (and
            (not 
                (exists (?d - Data) (hasData ?u ?d)) 
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
        :parameters (?f - Ship ?d - Data ?u - UUV)
        :precondition (and
            (hasData ?u ?d)
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
                (exists (?s - Sample) (shipSample ?f ?s))
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