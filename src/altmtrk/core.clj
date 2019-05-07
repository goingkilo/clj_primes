(ns altmtrk.core)

(defn is-prime [x]
    ;; 6k+/-1 test for primality
    (and
        (not (= x 1))
        (not (= x 0))
        (or
            ( = x 2)
            ( = x 3)
            (= 1 (mod x 6))
            (= 5 (mod x 6)))))

(defn first-n-primes [n predicate]
    (take n (filter predicate (range (* 10 n)))))


(defn gen-sequence [start count predicate ret]
    ;; this is an additional way to generate n primes without using builtin methods
    ;; it also uses injection to run the is-prime predicate
    ;; not used for now
    (cond
      (= count 0)           ret
      (predicate start)     (recur (+ start 1) (- count 1) predicate (conj ret start))
      :else                 (recur (+ start 1) count predicate ret)))


(defn make-table [n]
    (try

        (let [primes-list (first-n-primes n is-prime)]
            (doseq [x (cons 1 primes-list)]
                (do
                    (doseq [y (cons 1 primes-list)]

                        (if (and  (= x 1) (= y 1))
                            (print "\t ")
                            (print "\t" ( * x y))))

                    (println))))
     (catch Exception e (str "Error:" (.getMessage e)))))


(defn -main []
    (make-table))
