(ns mars-rover.command-test
	(:require [clojure.test :refer :all]
            [mars-rover.command :refer :all]
            [mars-rover.rover :as rover]
  )
)

(deftest test-move-rover-and-get-status-command
	(testing "it should move the rover"
		(let [initial-rover-location (rover/get-location)]
			(let [execution-result (move-rover-and-get-status [2 :S])]
				(is (string? execution-result))
				(is (not= initial-rover-location (rover/get-location)))
				(is (= "The rover is now at -2, 0"))
			)
		)
	)
)

(deftest test-invalid-input-command
	(testing "it should return an error message and not mutate rover position")
	(let [initial-rover-location (rover/get-location)]
		(is (= "Please enter correct input" (invalid-input)))
		(is (= initial-rover-location (rover/get-location)))
	)
)

(deftest test-get-status-command
	(testing "it should return the formatted string that contains the position of the rover"
		(rover/reset)
		(is (= "The rover is now at 0, 0" (get-status)))
	)
)
