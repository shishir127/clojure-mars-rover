(ns mars-rover.rover-test
  (:require [clojure.test :refer :all]
            [mars-rover.rover :refer :all]
            [mars-rover.navigation :as nav]
  )
)

(deftest test-get-location
  (testing "returns the formatted location of the rover"
  	(intern 'mars-rover.rover 'co-ordinates {:X 1 :Y 4})
    (is (= "1, 4" (get-location)))
  )
)

(deftest test-get-orientation
	(testing "returns the current orientation of the rover"
		(intern 'mars-rover.rover 'orientation :N)
		(is (= (get nav/directions :N) (get-orientation)))
		(intern 'mars-rover.rover 'orientation :S)
		(is (= (get nav/directions :S) (get-orientation)))
		(intern 'mars-rover.rover 'orientation :E)
		(is (= (get nav/directions :E) (get-orientation)))
		(intern 'mars-rover.rover 'orientation :W)
		(is (= (get nav/directions :W) (get-orientation)))
	)
)

(deftest test-set-orientation
	(testing "sets the orientation of the rover"
		(intern 'mars-rover.rover 'orientation :N)
		(let [new-orientation :S]
			(set-orientation new-orientation)
			(is (= new-orientation orientation))
		)
	)
)

(deftest test-set-orientation-with-invalid-direction
	(testing "returns nil when the direction is invalid"
		(intern 'mars-rover.rover 'orientation :N)
		(is (= false (set-orientation :T)))
		(is (= :N orientation))
	)
)
