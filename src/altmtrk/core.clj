(ns altmtrk.core)



(defn is-prime-1 [n]
    ;; brute force test for primes
        (cond
            (or (= n 0) (= n 1))
                :undefined
            (= 2 n)
                true
            :else
                (let [limit (+ 1 (Math/sqrt n))]
                    (every? false? (map #(zero? (rem n %)) (range 2 limit))))))


(defn is-prime-2 [x]
    ;; 6k+/-1 test for primality
    (cond
        (or
            (= x 0)
            (= x 1))
                :undefined
        :else
            (or
                (= x 2)
                (= x 3)
                (or
                    (= 1 (mod x 6))
                    (= 5 (mod x 6))))))


(defn gen-sequence [start count predicate ret]
        (cond
          (= count 0)           ret
          (predicate start)     (recur (+ start 1) (- count 1) predicate (conj ret start))
          :else                 (recur (+ start 1) count predicate ret)))



(defn generate-first-n-primes [n]
    (reverse (gen-sequence 2 n is-prime-2 '())))


(defn make-table []
    (let [first-10 (generate-first-n-primes 10)]
        (doseq [x first-10]
            (do
                (doseq [y first-10]
                    (print "\t" ( * x y)))
                        (println)))))


;; for measuring performance only
(defn benchmark [n]
    (println n (time (generate-first-n-primes n))))

(defn -main []
    (make-table))