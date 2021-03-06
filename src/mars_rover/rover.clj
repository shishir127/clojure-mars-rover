(ns mars-rover.rover
	(:require [mars-rover.navigation :as nav])
)

(def ^{:private true} co-ordinates {:X 0 :Y 0})

(defn get-location []
	(str (get co-ordinates :X) ", " (get co-ordinates :Y))
)

(defn move [steps direction]
	(def co-ordinates (nav/get-new-position co-ordinates steps direction))
)

(defn reset [] (def ^{:private true} co-ordinates {:X 0 :Y 0}))
