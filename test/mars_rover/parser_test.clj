(ns mars-rover.parser-test
	(:require [clojure.test :refer :all]
						[mars-rover.parser :refer :all]
						[mars-rover.command :as cmd]
	)
)

(deftest test-parse-returns-steps-direction
	(testing "returns the steps and direction"
		(let [ parsed-command (parse "2 W")]
			(is (= {:function cmd/move-rover-and-get-status :arguments [2 :W]} parsed-command))
		)
	)
)

(deftest test-parse-returns-steps-direction-when-lowercase
	(testing "returns the steps and capitalizes direction"
		(let [ parsed-command (parse "4 w")]
			(is (= {:function cmd/move-rover-and-get-status :arguments [4 :W]} parsed-command))
		)
	)
)

(deftest test-parse-for-invalid-direction
	(testing "returns a map indicating input is invalid"
		(let [ parsed-command (parse "2 X")]
			(is (= {:function cmd/invalid-input :arguments []} parsed-command))
		)
	)
)

(deftest test-parse-for-invalid-steps
	(testing "returns a map indicating input is invalid"
		(let [ parsed-command (parse "abc W")]
			(is (= {:function cmd/invalid-input :arguments []} parsed-command))
		)
	)
)

(deftest test-parse-for-invalid-input
	(testing "returns a map indicating input is invalid"
		(let [ parsed-command (parse "abc adj 91")]
			(is (= {:function cmd/invalid-input :arguments []} parsed-command))
		)
	)
)

(deftest test-parse-quit-command
	(testing "returns the quit command type"
		(let [ parsed-command (parse "quit")]
			(is (= {:function cmd/quit-program :arguments []} parsed-command))	
		)
	)
)

(deftest test-parse-quit-command-for-invalid-input
	(testing "returns an invalid command"
		(let [ parsed-command (parse "quite")]
			(is (= {:function cmd/invalid-input :arguments []} parsed-command))
		)
	)
)
