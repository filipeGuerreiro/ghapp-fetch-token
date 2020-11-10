# Github App Token Fetcher

A Clojure library designed to acquire an installation access token for your Github Apps.

More information can be found at [Github's official docs](https://docs.github.com/en/free-pro-team@latest/developers/apps/authenticating-with-github-apps).

[![Clojars Project](https://img.shields.io/clojars/v/ghapp-token-fetch.svg)](https://clojars.org/ghapp-token-fetch)

## Build

Requires leiningen

`lein uberjar`

## Usage

Requires java >8

`java -jar <path/to/jar-standalone> --app-id N --installation-id N --pkey-file-path S [--endpoint S]`

Example:

`java -jar <path/to/jar-standalone> -a 1591 -i 18890 -k "/home/filipe/Downloads/gitapp.private-key.pem" -e "https://git.bigcorp.com/api/v3/"`

## License

Copyright 2020 Filipe Guerreiro

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
