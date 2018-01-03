(ns mars-rover.command
	(:require [clojure.string :as string]
						[mars-rover.navigation :as nav]
						[mars-rover.rover :as rover]
	)
)

(defn get-status [] (format "The rover is now at %s" (rover/get-location)))

(defn move-rover-and-get-status [[steps direction]]
  (rover/move steps direction)
  (get-status)
)

(defn quit-program [& args]
	(println "Goodbye")
	(System/exit 0)
)

(defn invalid-input [& args]
	"Please enter correct input"
)
