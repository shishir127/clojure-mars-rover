(ns mars-rover.navigation)

(def directions {:N "north" :S "south" :E "east" :W "west"})

(defn get-new-position
	"Given the current position and direction of movement, will compute the new position"
	[current-position steps direction]
	(case direction
		:N {:X (get current-position :X) :Y (+ (get current-position :Y) steps)}
		:S {:X (get current-position :X) :Y (- (get current-position :Y) steps)}
		:E {:X (+ (get current-position :X) steps) :Y (get current-position :Y)}
		:W {:X (- (get current-position :X) steps) :Y (get current-position :Y)}
	)
)