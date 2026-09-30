(ns rich4clojure.easy.problem-041
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Drop Every Nth Item =
;; By 4Clojure user: dbyrne
;; Difficulty: Easy
;; Tags: [seqs]
;; 
;; Write a function which drops every Nth item from a
;; sequence.

(def __ b)

(defn a [coll n]
  (let [idx-coll (map list (range) coll)
        fltrd-idx-coll (filter (fn [[i _]] (not= 0 (rem (inc i) n))) idx-coll)]
    (mapv #(nth % 1) fltrd-idx-coll)))
  
 (defn b [coll n]
   (keep-indexed (fn [idx item] (when (not= 0 (rem (+ 1 idx) n)) item)) coll))

(comment
  (filter #(rem (nth % 1) 2)
          (map list [:a :b :c :d :e :f :g] (range)))
  (rem 20 2)  
  (a [:a :b :c :d :e :f :g] 2)
  ;;=> [:a :c :e :g]
  (a [:a :b :c :d :e :f :g] 3)
  ;;=> [:a :d :g]
  (a [1 2 3 4 5 6 7 8] 3)
  (map-indexed (fn [idx item] [idx item]) [:a :b :c :d :e :f :g])
  (keep-indexed (fn [idx item] (when (not= 0 (rem (+ idx 1) 3)) item)) [:a :b :c :d :e :f :g :h :i :j])
  ;;=> (:a :b :d :e :g :h :j)
  ;;=> ([0 :a] [1 :b] [2 :c] [3 :d] [4 :e] [5 :f] [6 :g])
  (map list (range) [:a :b :c :d :e :f :g])
  ;;=> ((0 :a) (1 :b) (2 :c) (3 :d) (4 :e) (5 :f) (6 :g))
  (partition-all)
  )
  ;;=> [1 4 7]
  

(tests
  (__ [1 2 3 4 5 6 7 8] 3) := [1 2 4 5 7 8]
  (__ [:a :b :c :d :e :f] 2) := [:a :c :e]
  (__ [1 2 3 4 5 6] 4) := [1 2 3 5 6])

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/03788b118a3d7923f7aae143e8ef1aee