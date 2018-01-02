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
  (println (format "The rover is now at %s" (rover/get-location)))
  (def continue-program true)
  (while continue-program
  	(def user-input (string/trim (read-line)))
		(println (command/parse user-input))
		(def continue-program false)
  )
)
