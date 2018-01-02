(ns mars-rover.core
	(:require [mars-rover.rover :as rover]
						[mars-rover.command :as command]
			  		[clojure.string :as string]
	)
)

(defn print-status [] (println (format "The rover is now at %s" (rover/get-location))))

(defn move-rover-and-print-status [steps direction] 
  (rover/move steps direction)
  (print-status)
)

(defn -main
  "Runs the mars rover simulator"
  [& args]
  (println "Starting the Mars rover simulator")
  (print-status)
  (def continue-program true)
  (while continue-program
  	(def user-input (string/trim (read-line)))
		(let [command (command/parse user-input)]
      (if (get command :valid)
        (move-rover-and-print-status (get command :steps) (get command :direction))
        (println "Please enter correct input")
      )
    )
		; (def continue-program false)
  )
)
