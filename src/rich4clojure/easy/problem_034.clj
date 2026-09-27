(ns rich4clojure.easy.problem-034
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Implement range =
;; By 4Clojure user: dbyrne
;; Difficulty: Easy
;; Tags: [seqs core-functions]
;; 
;; Write a function which creates a list of all integers
;; in a given range.

(def restricted [range])

(def __ c)

(defn a [start end]
  (loop [start start
         end end
         acc '()]
    (if (= start end)
      (reverse acc)
      (recur (inc start) end (conj acc start))))
  )

(defn b [start end]
  (take-while #(< % end) (iterate inc start)))

(defn c [start end]
  (take  (- end start) (iterate inc start)))

(comment
  (for [x (range 1 5)]
    x)
  ;;=> (1 2 3 4)
  (for [x (range 1 5)
        y [(* 2 x)]]
    [x y])
  ;;=> ([1 2] [2 4] [3 6] [4 8])
  (for [x (range 1 5)
        y [(* 2 x)]]
    y)
  ;;=> (2 4 6 8)
  (for [x    (range 1 5)
        :let [y (* 2 x)]]
    y)
  ;;=> (2 4 6 8)
  (for [x     (range 1 5)
        :when (even? x)]
    x)
  ;;=> (2 4)
  (for [x      (range 1 5)
        :while (odd? x)]
    x)
  ;;=> (1)
  (for [x (range 1 6)
        :let [y (* x x)
              z (* x x x)]]
    [x y z])
  ;;=> ([1 1 1] [2 4 8] [3 9 27] [4 16 64] [5 25 125])
  (for [x (range 1 6)
        y [(* x x)]
        z [(* x x x)]]
    [x y z])
  ;;=> ([1 1 1] [2 4 8] [3 9 27] [4 16 64] [5 25 125])
  
  (loop [start 1
         end 5
         acc '()
         ]
    (if (>= start end)
      (reverse acc)
      (recur (inc start) end (conj acc start))))
  ;;=> (1 2 3 4)
  (take-while #(< % 5) (iterate inc 1))
  
  (map first (take 5 (iterate (fn [[a b]] [b (+ a b)]) [0 1])))
  ;;=> (0 1 1 2 3)
  )

(tests
  (__ 1 4) := '(1 2 3)
  (__ -2 2) := '(-2 -1 0 1)
  (__ 5 8) := '(5 6 7))

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/6ebd843c6422d507efa327bee4bf0b50