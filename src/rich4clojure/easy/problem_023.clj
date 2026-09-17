(ns rich4clojure.easy.problem-023
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Reverse a Sequence =
;; By 4Clojure user: dbyrne
;; Difficulty: Easy
;; Tags: [seqs core-functions]
;; 
;; Write a function which reverses a sequence.

(def restricted [reverse rseq])

(def __1 
  (fn [s]
    (reduce (fn [acc b] (cons b acc)) [] s)))

(def __2 
  #(reduce (fn [acc b] (cons b acc)) [] %))

(def __3
  (let [rdcr #(cons %2 %1)]
    #(reduce rdcr [] %)))

(def __ #(reduce conj () %))

(comment
  butlast)

(tests
  (__ [1 2 3 4 5]) := [5 4 3 2 1]
  (__ (sorted-set 5 7 2 7)) := '(7 5 2)
  (__ [[1 2][3 4][5 6]]) := [[5 6][3 4][1 2]])

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/904085bff870b46beca9c51605e1b3fc