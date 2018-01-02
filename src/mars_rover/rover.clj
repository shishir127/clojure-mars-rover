(ns mars-rover.rover)

(def co-ordinates {:X 0 :Y 0})

(def orientation :N)

(defn get-location []
	(str (get co-ordinates :X) ", " (get co-ordinates :Y))
)

(def directions {:N "north" :S "south" :E "east" :W "west"})

(defn get-orientation []
	(get directions orientation)
)
