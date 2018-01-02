(ns mars-rover.parser-test
	(:require [clojure.test :refer :all]
						[mars-rover.parser :refer :all]
	)
)

(deftest test-parse-returns-steps-direction
	(testing "returns the steps and direction"
			(let [ parsed-command (parse "2 W")]
				(is (= 2 (get parsed-command :steps)))
				(is (= :W (get parsed-command :direction)))
				(is (= true (get parsed-command :valid)))
				(is (= :navigation (get parsed-command :type)))
			)
	)
)

(deftest test-parse-returns-steps-direction-when-lowercase
	(testing "returns the steps and capitalizes direction"
			(let [ parsed-command (parse "4 w")]
				(is (= 4 (get parsed-command :steps)))
				(is (= :W (get parsed-command :direction)))
				(is (= true (get parsed-command :valid)))
				(is (= :navigation (get parsed-command :type)))
			)
	)
)

(deftest test-parse-for-invalid-direction
	(testing "returns a map indicating input is invalid"
			(let [ parsed-command (parse "2 X")]
				(is (= false (get parsed-command :valid)))
			)
	)
)

(deftest test-parse-for-invalid-steps
	(testing "returns a map indicating input is invalid"
			(let [ parsed-command (parse "abc W")]
				(is (= false (get parsed-command :valid)))
			)
	)
)

(deftest test-parse-for-invalid-input
	(testing "returns a map indicating input is invalid"
			(let [ parsed-command (parse "abc adj 91")]
				(is (= false (get parsed-command :valid)))
			)
	)
)

(deftest test-parse-quit-command
	(testing "returns the quit command type"
			(let [ parsed-command (parse "quit")]
				(is (= true (get parsed-command :valid)))
				(is (= :quit (get parsed-command :type)))
			)
	)
)

(deftest test-parse-quit-command-for-invalid-input
	(testing "returns an invalid command"
			(let [ parsed-command (parse "quite")]
				(is (= false (get parsed-command :valid)))
			)
	)
)