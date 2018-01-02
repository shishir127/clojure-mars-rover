(ns mars-rover.navigation)

(def directions {:N "north" :S "south" :E "east" :W "west"})

(defn get-new-position
	"Given the current position and direction of movement, will compute the new position"
	[current-position steps direction]
	(case direction
		(:N ({:X (get current-position :X) :Y (+ steps (get current-position :Y))}))
		(:S ({:X (get current-position :X) :Y (- steps (get current-position :Y))}))
		(:E ({:X (+ steps (get current-position :X)) :Y (get current-position :Y)}))
		(:W ({:X (- steps (get current-position :X)) :Y (get current-position :Y)}))
	)
)