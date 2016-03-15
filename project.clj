(defproject plasio-ui "0.1.5"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.228"]
                 [org.clojure/core.async "0.1.346.0-17112a-alpha"]
                 [prismatic/om-tools "0.3.12"]
                 [cljsjs/gl-matrix "2.3.0-jenanwise-0"]
                 [racehub/om-bootstrap "0.5.3"]
                 [cljs-http "0.1.31"]]

  :plugins [[lein-cljsbuild "1.1.2"]
            [lein-figwheel "0.5.0-6"]]

  :profiles {:dev {:dependencies [[com.cemerick/piggieback "0.2.1"]]
                   :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}}}

  :source-paths ["src"]

  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"]

  :cljsbuild {
    :builds [{:id "dev"
              :source-paths ["src" "vendor/src"]

              :figwheel { :on-jsload "plasio-ui.core/on-js-reload" }

              :compiler {:main plasio-ui.core
                         :asset-path "js/compiled/out"
                         :output-to "resources/public/js/compiled/plasio_ui.js"
                         :output-dir "resources/public/js/compiled/out"
                         :source-map-timestamp true }}
             {:id "min"
              :source-paths ["src" "vendor/src"]
              :compiler {:output-to "resources/public/js/compiled/plasio_ui.js"
                         :main plasio-ui.core
                         :optimizations :advanced
                         :externs ["vendor/externs/nouislider.js"
                                   "vendor/externs/plasiolib.js"
                                   "vendor/externs/extras.js"
                                   "vendor/externs/react-dom.ext.js"
                                   "vendor/externs/react.ext.js"
                                   "vendor/externs/google_maps_api_v3_11.js"]
                         :pretty-print false}}]}

  :figwheel {
             ;; :http-server-root "public" ;; default and assumes "resources"
             ;; :server-port 3449 ;; default
             :css-dirs ["resources/public/css"] ;; watch and update CSS

             ;; Start an nREPL server into the running figwheel process
             :nrepl-port 7888

             ;; Server Ring Handler (optional)
             ;; if you want to embed a ring handler into the figwheel http-kit
             ;; server, this is for simple ring servers, if this
             ;; doesn't work for you just run your own server :)
             ;; :ring-handler hello_world.server/handler

             ;; To be able to open files in your editor from the heads up display
             ;; you will need to put a script on your path.
             ;; that script will have to take a file path and a line number
             ;; ie. in  ~/bin/myfile-opener
             ;; #! /bin/sh
             ;; emacsclient -n +$2 $1
             ;;
             ;; :open-file-command "myfile-opener"

             ;; if you want to disable the REPL
             ;; :repl false

             ;; to configure a different figwheel logfile path
             ;; :server-logfile "tmp/logs/figwheel-logfile.log"
             })
