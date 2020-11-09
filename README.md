# Github App Token Fetcher

A Clojure library designed to acquire an installation access token for your Github Apps.

More information can be found at [Github's official docs](https://docs.github.com/en/free-pro-team@latest/developers/apps/authenticating-with-github-apps).

[![Clojars Project](https://clojars.org/ghapp-token-fetch/latest-version.svg)](https://clojars.org/ghapp-token-fetch)

## Build

Requires leiningen

`lein uberjar`

## Usage

Requires java >8

`java -jar <path/to/jar-standalone> --app-id N --installation-id N --pkey-file-path S --endpoint S`

Example:

`java -jar <path/to/jar-standalone> -a 1591 -i 18890 -k "/home/filipe/Downloads/gitapp.private-key.pem" -e "https://git.bigcorp.com/api/v3/"`

## License

Copyright © 2020

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
