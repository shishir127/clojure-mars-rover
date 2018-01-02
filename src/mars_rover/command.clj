(ns mars-rover.command
	(:require [clojure.string :as string]
						[mars-rover.navigation :as nav]
						[mars-rover.rover :as rover]
	)
)

(defn get-status [] (format "The rover is now at %s" (rover/get-location)))

(defn move-rover-and-get-status [steps direction] 
  (rover/move steps direction)
  (get-status)
)

(defn quit-program []
	(println "Goodbye")
	(System/exit 0)
)

(defn execute [command]
	(if (get command :valid)
		(case (get command :type)
			:quit (quit-program)
			:navigation (move-rover-and-get-status (get command :steps) (get command :direction))
		)
		"Please enter correct input"
	)
)
