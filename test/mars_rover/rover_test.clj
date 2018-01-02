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
