(ns j2edn.core
  (:require [clojure.data.json :as json])
  (:gen-class))

(defn -main []
  (->> (repeatedly #(json/read *in*
                               :key-fn keyword
                               :eof-error? false
                               :eof-value ::eof))
       (take-while #(not= ::eof %))
       (run! prn)))
