(ns rich4clojure.easy.problem-042
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Factorial Fun =
;; By 4Clojure user: amalloy
;; Difficulty: Easy
;; Tags: [math]
;; 
;; Write a function which calculates factorials.

(def __ d)

(defn a [n]
  (loop [i 1
         acc 1]
    (if (> i n)
      acc
      (recur (inc i) (* acc i)))))

(defn b [n]
  (reduce (fn [acc a]
            (* acc a)) 1 (range 1 (inc n))))

(defn c [n]
  (reduce * (range 1 (inc n))))

(defn d [n]
  (apply * (range 1 (inc n))))

(comment
(* 1 2 3 4 5 6 7 8)
;;=> 40320
(a 8)  
(b 5)  
(c 5)  
(d 5)  
  )

(tests
  (__ 1) := 1
  (__ 3) := 6
  (__ 5) := 120
  (__ 8) := 40320)

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/850039024c0d503cce2b2e98ca1803c5