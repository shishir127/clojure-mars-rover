(ns mars-rover.core
	(:require [mars-rover.command :as command]
			  		[clojure.string :as string]
	)
)

(defn -main
  "Runs the mars rover simulator"
  [& args]
  (println "Starting the Mars rover simulator")
  (println (command/get-status))
  (while true
  	(def user-input (string/trim (read-line)))
		(let [command (command/parse user-input)]
      (println (command/execute command))
    )
  )
)
