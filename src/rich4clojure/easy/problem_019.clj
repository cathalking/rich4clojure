(ns rich4clojure.easy.problem-019
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Last Element =
;; By 4Clojure user: dbyrne
;; Difficulty: Easy
;; Tags: [seqs core-functions]
;; 
;; Write a function which returns the last element in a
;; sequence.

(def restricted [last])

(def __1 (fn [s]
          (first (reverse s))) #_:tests-will-fail)
(def __2 (fn [c]
          (loop [f (first c)
                 r (rest c)]
            (if (empty? r)
              f
              (recur (first r) (rest r))))) #_:tests-will-fail)
(def __3  #(loop [f (first %)
                   r (rest %)]
              (if (empty? r)
                f
                (recur (first r) (rest r)))) #_:tests-will-fail)
(def __4 (fn [c]
           (reduce (fn [_ b] b) c)))
(def __ #(reduce (fn [_ b] b) %))

(comment
  
  )

(tests
  (__ [1 2 3 4 5]) := 5
  (__ '(5 4 3)) := 3
  (__ ["b" "c" "d"]) := "d")

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/374c499f3dad0203503b7dae16bf86f4