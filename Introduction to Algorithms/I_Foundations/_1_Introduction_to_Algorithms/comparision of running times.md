# Comparison of running times

### For each function _f(n)_ and time _t_ in the following table, determine the largest size _n_ of a problem that can be solved in time _t_, assuming that the algorithm to solve the problem takes _f(n)_ microseconds.


|              | 1 second                   | 1 minute                       | 1 hour                          | 1 day                            | 1 month                            | 1 year                              | 1 century                              |
|--------------|----------------------------|--------------------------------|---------------------------------|----------------------------------|------------------------------------|-------------------------------------|----------------------------------------|
| **ln(n)**    | 2<sup>10<sup>6</sup></sup> | 2<sup>6 * 10<sup>7</sup></sup> | 2<sup>36 * 10<sup>8</sup></sup> | 2<sup>864 * 10<sup>8</sup></sup> | 2<sup>25920 * 10<sup>8</sup></sup> | 2<sup>315360 * 10<sup>8</sup></sup> | 2<sup>315556736 * 10<sup>8</sup></sup> |
| **\sqrt{n}** | 10<sup>12</sup>            | 36 * 10<sup>14</sup>           | 1296 * 10<sup>16</sup>          | 746496 * 10<sup>16</sup>         | 6718464 * 10<sup>18</sup>          | 994519296 * 10<sup>18</sup>         | 995827586973696 * 10<sup>16</sup>      |
| **\sqrt{n}** | 10<sup>6</sup>             | 6 * 10<sup>7</sup>             | 36 * 10<sup>8</sup>             | 864 * 10<sup>8</sup>             | 2592 * 10<sup>9</sup>              | 31536 * 10<sup>9</sup>              | 31556736 * 10<sup>8</sup>              |
| **nln(n)**   | 62746                      | 2801417                        | 133378058                       | 2755147513                       | 71870856404                        | 797633893349                        | 68654697441062                         |
| **n^2n**     | 1000                       | 7745                           | 60000                           | 293938                           | 1609968                            | 5615692                             | 56175382                               |
| **n^3**      | 100                        | 391                            | 1532                            | 4420                             | 13736                              | 31593                               | 146677                                 |
| **2^n**      | 19                         | 25                             | 31                              | 36                               | 41                                 | 44                                  | 51                                     |
| **n!**       | 9                          | 11                             | 12	                             | 13                               | 15                                 | 16                                  | 17                                     |


