(ns rich4clojure.easy.problem-066
  (:require [hyperfiddle.rcf :refer [tests]]
            [clojure.set :refer [intersection]]))

;; = Greatest Common Divisor =
;; By 4Clojure user: dbyrne
;; Difficulty: Easy
;; 
;; Given two integers, write a function which returns the
;; greatest common divisor.

(def __ a)

(defn b [i j]
(if (= 0 j)
  i
  (recur j (rem i j)))
  )

(defn divisors [x]
  (keep #(when (= 0 (rem x %)) %)
           
           (range 1 (inc x)))
  )

(defn a [i j]
(->> (intersection (set (divisors i)) (set (divisors j)))
     (apply max))
  )

(comment
  (let [i 20
        j 40]
    (->> (intersection (set (divisors i)) (set (divisors j)))
         (apply max))
    )
    (b 20 40)
    (b 10 5)
    (b 5 7)
    (b 1023 858)
  
  )

(tests
  (__ 2 4) := 2
  (__ 10 5) := 5
  (__ 5 7) := 1
  (__ 1023 858) := 33)

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/4aa85a5a1d6e6962548e6dc69a02a55e