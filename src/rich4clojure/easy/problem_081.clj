(ns rich4clojure.easy.problem-081
  (:require [hyperfiddle.rcf :refer [tests]]))

;; = Set Intersection =
;; By 4Clojure user: dbyrne
;; Difficulty: Easy
;; Tags: [set-theory]
;; 
;; Write a function which returns the intersection of two
;; sets. The intersection is the sub-set of items that
;; each set has in common.

(def restricted [intersection])

(def __ b)

(defn a [sx sy]
  (let [[s1 s2] (if (<= (count sx) (count sy))
                  [sx sy]
                  [sy sx])]
    (->>
     (keep #(when (s2 %) %) s1)
     set)
    )
  )

(defn b [sx sy] 
  (set (filter sx sy)))

  (def sx #{0 1 2 3})
  (def sy #{2 3 4 5})
(comment
  (let [[s1 s2] (if (<= (count sx) (count sy))
                  [sx sy]
                  [sy sx])]
    ;; [s1 s2]
    (->>
     ;; (keep #(when (contains? sy %) %) sx)
     (keep #(when (s2 %) %) s1)
     set)
    )
  ;;=> [#{0 1 3 2} #{4 3 2 5}]
  (filter sy sx)
  
  )

(tests
  (__ #{0 1 2 3} #{2 3 4 5}) := #{2 3}
  (__ #{0 1 2} #{3 4 5}) := #{}
  (__ #{:a :b :c :d} #{:c :e :a :f :d}) := #{:a :c :d})

;; Share your solution, and/or check how others did it:
;; https://gist.github.com/a51be488815f09d5d8e68e93d16f61e8