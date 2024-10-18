(define (problem windfarm-mission-2)
    (:domain windfarm)

    (:objects
        Ship_1 WP1 WP2 WP3 WP4 WP5 - Waypoint
        Ship1 - Ship
        UUV1 - UUV
        IMG1 SCAN1 - Data
        SAMPLE1 - Sample
    )

    (:init
        (path Ship_1 WP1)
        
        (path WP1 WP4)
        (path WP1 WP2)
        (path WP1 Ship_1)

        (path WP2 WP3)

        (path WP3 WP5)

        (path WP4 WP3)

        (path WP5 WP1)

        (DataLocation IMG1 WP5)
        (DataLocation SCAN1 WP3)
        (SampleLocation SAMPLE1 WP1)

        (shipLocation Ship1 Ship_1)
        (robotAt UUV1 Ship_1)
    )

    (:goal
        (and
            (shipSample Ship1 SAMPLE1)
            (shipData Ship1 IMG1)
            (shipData Ship1 SCAN1)
        )
    )
)