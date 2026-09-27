(ns rich4clojure.easy.problem-039
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Interleave Two Seqs =
;; By 4Clojure user: dbyrne
;; Difficulty: Easy
;; Tags: [seqs core-functions]
;; 
;; Write a function which takes two sequences and returns
;; the first item from each, then the second item from
;; each, then the third, etc.

(def restricted [interleave])

(def __ b)
(defn a [xs ys]
  (apply concat (map #(list %1 %2) xs ys)))

(defn b [xs ys]
  (loop [[hx & tx] xs
         [hy & ty] ys
         acc '()]
    (if (or (nil? hx) (nil? hy))
      (reverse acc)
      (recur tx ty (conj acc hx hy)))))

(comment

  (apply concat (map #(list %1 %2) [1 2 3] [:a :b :c]))
  (loop [[hx & tx] [1 2 3]
         [hy & ty] [:a :b :c]
         acc       '()]
    (if (nil? hx)
      (reverse acc)
      (recur tx ty (conj acc hx hy))))
  (__ [1 2 3] [:a :b :c])
  (__ [1 2 3 4] [5]))

(tests
 (__ [1 2 3] [:a :b :c]) := '(1 :a 2 :b 3 :c)
 (__ [1 2] [3 4 5 6]) := '(1 3 2 4)
 (__ [1 2 3 4] [5]) := [1 5]
 (__ [30 20] [25 15]) := [30 25 20 15])

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/65d3ee0ffa567e78927bbebbb9d9cc89