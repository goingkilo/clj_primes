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

(defn first-n-primes [n]
    (take n (filter is-prime (range (* 10 n)))))


(defn make-table [n]

    (try

        (let [primes-list (first-n-primes n)]
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
