(ns mars-rover.core
	(:require [mars-rover.rover :as rover])
)

(defn -main
  "Runs the mars rover simulator"
  [& args]
  (println "Starting the Mars rover simulator")
  (println (str "The rover is now at " (rover/get-location) " and facing " (rover/get-orientation)))
)
