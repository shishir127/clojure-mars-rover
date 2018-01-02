(ns mars-rover.command-test
	(:require [clojure.test :refer :all]
            [mars-rover.command :refer :all]
            [mars-rover.rover :as rover]
  )
)

(deftest test-execute-when-quitting
	(testing "it should not mutate rover position"
		(let [initial-rover-location (rover/get-location)]
			(with-redefs [quit-program (fn [] "quitting program")]
				(let [execution-result (execute {:type :quit :valid true}) ]
					(is (= initial-rover-location (rover/get-location)))
					(is (= "quitting program" execution-result))
				)
			)
		)
	)
)

(deftest test-execute-when-navigating
	(testing "it should move the rover"
		(let [initial-rover-location (rover/get-location)]
			(let [execution-result (execute {:type :navigation :steps 2 :direction :S :valid true})]
				(is (string? execution-result))
				(is (not= initial-rover-location (rover/get-location)))
				(is (= "The rover is now at -2, 0"))
			)
		)
	)
)

(deftest test-execute-for-invalid-command
	(testing "it should return an error and not mutate rover position"
		(let [initial-rover-location (rover/get-location)]
			(let [execution-result (execute {:valid false})]
				(is (string? execution-result))
				(is (= initial-rover-location (rover/get-location)))
				(is (= "Please enter correct input" execution-result))
			)
		)
	)
)