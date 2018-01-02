(ns mars-rover.core
	(:require [mars-rover.rover :as rover]
						[mars-rover.command :as command]
			  		[clojure.string :as string]
	)
)

(defn -main
  "Runs the mars rover simulator"
  [& args]
  (println "Starting the Mars rover simulator")
  (println (format "The rover is now at %s and facing %s" (rover/get-location) (rover/get-orientation)))
  (def continue-program true)
  (while continue-program
  	(def user-input (string/trim (read-line)))
		(println (command/execute user-input))
		(def continue-program false)
  )
)
