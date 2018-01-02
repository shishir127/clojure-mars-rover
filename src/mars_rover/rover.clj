(ns mars-rover.rover
	(:require [mars-rover.navigation :as nav])
)

(def co-ordinates {:X 0 :Y 0})

(def orientation :N)

(defn get-location []
	(str (get co-ordinates :X) ", " (get co-ordinates :Y))
)

(defn get-orientation []
	(get nav/directions orientation)
)

(defn set-orientation [new-orientation]
	(if (contains? nav/directions new-orientation)
		(def orientation new-orientation)
		false
	)
)