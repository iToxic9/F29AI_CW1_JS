(define (problem windfarm-mission-3)
    (:domain windfarm)
    (:requirements :disjunctive-preconditions)

    (:objects
        Ship_1 Ship_2 WP1 WP2 WP3 WP4 WP5 WP6 - Waypoint
        Ship1 Ship2 - Ship
        UUV1 UUV2 - UUV
        IMG1 IMG2 SCAN1 SCAN2 - Data
        SAMPLE1 SAMPLE2 - Sample
    )

    (:init
        (path Ship_1 WP1)
        (path Ship_2 WP1)

        (path WP1 Ship_1)
        (path WP1 Ship_2)
        (path WP1 WP2)

        (path WP2 WP1)
        (path WP2 WP3)
        (path WP2 WP4)

        (path WP3 WP5)

        (path WP4 WP2)

        (path WP5 WP6)
        (path WP5 WP3)

        (path WP6 WP4)

        (DataLocation IMG1 WP3)
        (DataLocation IMG2 WP2)
        (DataLocation SCAN1 WP4)
        (DataLocation SCAN2 WP6)

        (SampleLocation SAMPLE1 WP5)
        (SampleLocation SAMPLE2 WP1)

        (shipLocation Ship1 Ship_1)
        (shipLocation Ship2 Ship_2)
        (robotAt UUV1 WP2)
        (robotAt UUV2 Ship_2)

    )

    (:goal
        (and
            (or (shipSample Ship1 SAMPLE1) (shipSample Ship2 SAMPLE1))
            (or (shipSample Ship1 SAMPLE2) (shipSample Ship2 SAMPLE2))
            (shipData Ship1 IMG1)
            (shipData Ship1 SCAN1)
            (shipData Ship2 IMG2)
            (shipData Ship2 SCAN2)
        )
    )
)