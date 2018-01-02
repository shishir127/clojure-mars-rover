(ns mars-rover.core
	(:require [mars-rover.command :as command]
			  		[clojure.string :as string]
	)
)

(defn -main
  "Runs the mars rover simulator"
  [& args]
  (println "Starting the Mars rover simulator")
  (command/print-status)
  (def continue-program true)
  (while continue-program
  	(def user-input (string/trim (read-line)))
		(let [command (command/parse user-input)]
      (if (get command :valid)
        (command/execute command)
        (println "Please enter correct input")
      )
    )
		; (def continue-program false)
  )
)
