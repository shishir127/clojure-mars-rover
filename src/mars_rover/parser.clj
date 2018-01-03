(ns mars-rover.parser
	(:require [mars-rover.navigation :as nav]
			  [clojure.string :as string]
			  [mars-rover.command :as cmd]
	)
)

(defn- valid-number? [number]
	(try
		(Integer/parseInt number)
		(catch Exception e false)
	)
)

(defn- valid-direction? [direction] 
	(contains? nav/directions (keyword (string/upper-case direction)))
)

(defn- parse-navigate-command [[steps direction]]
	(if (and (not (nil? steps)) (not (nil? direction)) (valid-number? steps) (valid-direction? direction))
		{:function cmd/move-rover-and-get-status :arguments [(Integer/parseInt steps) (keyword (string/upper-case direction))]}
		{:function cmd/invalid-input :arguments []}
	)
)

(defn- parse-quit-command [command-string]
	(if (= "quit" (first command-string))
		{:function cmd/quit-program :arguments []}
		{:function cmd/invalid-input :arguments []}
	)
)

(defn parse [input-string]
	"Parses the input"
	(let [inputs (string/split input-string #" ")]
		(if (= 1 (count inputs))
			(parse-quit-command inputs)
			(parse-navigate-command inputs)
		)
	)
)
