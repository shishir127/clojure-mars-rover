(ns mars-rover.core
	(:require [mars-rover.parser :as parser]
            [mars-rover.command :as command]
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
		(let [command-details (parser/parse user-input)]
      (println ((get command-details :function) (get command-details :arguments)))
    )
  )
)
