(ns rich4clojure.easy.problem-020
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Penultimate Element =
;; By 4Clojure user: dbyrne
;; Difficulty: Easy
;; Tags: [seqs]
;; 
;; Write a function which returns the second to last
;; element from a sequence.

(def __1 #(nth % (dec (dec (count %))))) :tests-will-fail
(def __2 #(first (take-last 2 %)))
(def __3 #(-> %
              reverse
              second))
(def __4 #(second (reverse %)))
(def __5 (comp second reverse))

(defn pipe_ [& fns]
  (fn [x]
   (reduce (fn [acc f] (f acc)) x fns)))

(defn pipe [& fns]
  #(reduce (fn [acc f] (f acc)) % fns))

(def __ (pipe reverse second))

(comment
  
  )

(tests
  (__ (list 1 2 3 4 5)) := 4
  (__ ["a" "b" "c"]) := "b"
  (__ [[1 2] [3 4]]) := [1 2])

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/bb564e188dc4d73aa37b714b64003dfe