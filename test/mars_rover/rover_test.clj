(ns mars-rover.rover-test
  (:require [clojure.test :refer :all]
            [mars-rover.rover :refer :all]
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
		(is (= (get directions :N) (get-orientation)))
		(intern 'mars-rover.rover 'orientation :S)
		(is (= (get directions :S) (get-orientation)))
		(intern 'mars-rover.rover 'orientation :E)
		(is (= (get directions :E) (get-orientation)))
		(intern 'mars-rover.rover 'orientation :W)
		(is (= (get directions :W) (get-orientation)))
	)
)
