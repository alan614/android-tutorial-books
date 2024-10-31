package com.alan.books

import com.alan.books.model.BookShelf
import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Test

class BookShelfTest {

    @Test
    fun bookShelf_deserialization_jsonToDataClasses() {
        val bookShelf: BookShelf = Json { ignoreUnknownKeys = true }.decodeFromString<BookShelf>("""
            {
              "kind": "books#volumes",
              "totalItems": 2856,
              "items": [
                {
                  "kind": "books#volume",
                  "id": "J9G50L3c14QC",
                  "etag": "LkYrXqkRrU8",
                  "selfLink": "https://www.googleapis.com/books/v1/volumes/J9G50L3c14QC",
                  "volumeInfo": {
                    "title": "The History of Jazz",
                    "authors": [
                      "Ted Gioia"
                    ],
                    "publisher": "Oxford University Press",
                    "publishedDate": "2011-05-09",
                    "description": "Ted Gioia's History of Jazz has been universally hailed as a classic--acclaimed by jazz critics and fans around the world. Now Gioia brings his magnificent work completely up-to-date, drawing on the latest research and revisiting virtually every aspect of the music, past and present. Gioia tells the story of jazz as it had never been told before, in a book that brilliantly portrays the legendary jazz players, the breakthrough styles, and the world in which it evolved. Here are the giants of jazz and the great moments of jazz history--Jelly Roll Morton, Louis Armstrong, Duke Ellington at the Cotton Club, cool jazz greats such as Gerry Mulligan, Stan Getz, and Lester Young, Charlie Parker and Dizzy Gillespie's advocacy of modern jazz in the 1940s, Miles Davis's 1955 performance at the Newport Jazz Festival, Ornette Coleman's experiments with atonality, Pat Metheny's visionary extension of jazz-rock fusion, the contemporary sounds of Wynton Marsalis, and the post-modernists of the current day. Gioia provides the reader with lively portraits of these and many other great musicians, intertwined with vibrant commentary on the music they created. He also evokes the many worlds of jazz, taking the reader to the swamp lands of the Mississippi Delta, the bawdy houses of New Orleans, the rent parties of Harlem, the speakeasies of Chicago during the Jazz Age, the after hours spots of corrupt Kansas city, the Cotton Club, the Savoy, and the other locales where the history of jazz was made. And as he traces the spread of this protean form, Gioia provides much insight into the social context in which the music was born.",
                    "industryIdentifiers": [
                      {
                        "type": "ISBN_13",
                        "identifier": "9780199831876"
                      },
                      {
                        "type": "ISBN_10",
                        "identifier": "0199831874"
                      }
                    ],
                    "readingModes": {
                      "text": true,
                      "image": true
                    },
                    "pageCount": 454,
                    "printType": "BOOK",
                    "categories": [
                      "Music"
                    ],
                    "maturityRating": "NOT_MATURE",
                    "allowAnonLogging": true,
                    "contentVersion": "0.12.7.0.preview.3",
                    "panelizationSummary": {
                      "containsEpubBubbles": false,
                      "containsImageBubbles": false
                    },
                    "imageLinks": {
                      "smallThumbnail": "http://books.google.com/books/content?id=J9G50L3c14QC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api",
                      "thumbnail": "http://books.google.com/books/content?id=J9G50L3c14QC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"
                    },
                    "language": "en",
                    "previewLink": "http://books.google.com.ph/books?id=J9G50L3c14QC&printsec=frontcover&dq=jazz+history&hl=&cd=1&source=gbs_api",
                    "infoLink": "https://play.google.com/store/books/details?id=J9G50L3c14QC&source=gbs_api",
                    "canonicalVolumeLink": "https://play.google.com/store/books/details?id=J9G50L3c14QC"
                  },
                  "saleInfo": {
                    "country": "PH",
                    "saleability": "FOR_SALE",
                    "isEbook": true,
                    "listPrice": {
                      "amount": 809.5,
                      "currencyCode": "PHP"
                    },
                    "retailPrice": {
                      "amount": 550.46,
                      "currencyCode": "PHP"
                    },
                    "buyLink": "https://play.google.com/store/books/details?id=J9G50L3c14QC&rdid=book-J9G50L3c14QC&rdot=1&source=gbs_api",
                    "offers": [
                      {
                        "finskyOfferType": 1,
                        "listPrice": {
                          "amountInMicros": 809500000,
                          "currencyCode": "PHP"
                        },
                        "retailPrice": {
                          "amountInMicros": 550460000,
                          "currencyCode": "PHP"
                        }
                      }
                    ]
                  },
                  "accessInfo": {
                    "country": "PH",
                    "viewability": "PARTIAL",
                    "embeddable": true,
                    "publicDomain": false,
                    "textToSpeechPermission": "ALLOWED",
                    "epub": {
                      "isAvailable": true,
                      "acsTokenLink": "http://books.google.com.ph/books/download/The_History_of_Jazz-sample-epub.acsm?id=J9G50L3c14QC&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api"
                    },
                    "pdf": {
                      "isAvailable": true,
                      "acsTokenLink": "http://books.google.com.ph/books/download/The_History_of_Jazz-sample-pdf.acsm?id=J9G50L3c14QC&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api"
                    },
                    "webReaderLink": "http://play.google.com/books/reader?id=J9G50L3c14QC&hl=&source=gbs_api",
                    "accessViewStatus": "SAMPLE",
                    "quoteSharingAllowed": false
                  },
                  "searchInfo": {
                    "textSnippet": "Here are the giants of jazz and the great moments of jazz history--Jelly Roll Morton, Louis Armstrong, Duke Ellington at the Cotton Club, cool jazz greats such as Gerry Mulligan, Stan Getz, and Lester Young, Charlie Parker and Dizzy ..."
                  }
                },
                {
                  "kind": "books#volume",
                  "id": "AycJAQAAMAAJ",
                  "etag": "Z5L3qFOCFtY",
                  "selfLink": "https://www.googleapis.com/books/v1/volumes/AycJAQAAMAAJ",
                  "volumeInfo": {
                    "title": "Introduction to Jazz History",
                    "authors": [
                      "Donald D. Megill",
                      "Richard S. Demory"
                    ],
                    "publisher": "Pearson",
                    "publishedDate": "2004",
                    "description": "For courses in Introduction to Jazz and Jazz History. Widely adopted for its well-balanced approach this classic chronological survey of jazz history brings the various historical styles to life by exploring them through the lives of the musicians and a study of their recordings.",
                    "industryIdentifiers": [
                      {
                        "type": "OTHER",
                        "identifier": "UOM:39015046295484"
                      }
                    ],
                    "readingModes": {
                      "text": false,
                      "image": false
                    },
                    "pageCount": 372,
                    "printType": "BOOK",
                    "categories": [
                      "Music"
                    ],
                    "maturityRating": "NOT_MATURE",
                    "allowAnonLogging": false,
                    "contentVersion": "0.4.2.0.preview.0",
                    "panelizationSummary": {
                      "containsEpubBubbles": false,
                      "containsImageBubbles": false
                    },
                    "imageLinks": {
                      "smallThumbnail": "http://books.google.com/books/content?id=AycJAQAAMAAJ&printsec=frontcover&img=1&zoom=5&source=gbs_api",
                      "thumbnail": "http://books.google.com/books/content?id=AycJAQAAMAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api"
                    },
                    "language": "en",
                    "previewLink": "http://books.google.com.ph/books?id=AycJAQAAMAAJ&q=jazz+history&dq=jazz+history&hl=&cd=2&source=gbs_api",
                    "infoLink": "http://books.google.com.ph/books?id=AycJAQAAMAAJ&dq=jazz+history&hl=&source=gbs_api",
                    "canonicalVolumeLink": "https://books.google.com/books/about/Introduction_to_Jazz_History.html?hl=&id=AycJAQAAMAAJ"
                  },
                  "saleInfo": {
                    "country": "PH",
                    "saleability": "NOT_FOR_SALE",
                    "isEbook": false
                  },
                  "accessInfo": {
                    "country": "PH",
                    "viewability": "NO_PAGES",
                    "embeddable": false,
                    "publicDomain": false,
                    "textToSpeechPermission": "ALLOWED",
                    "epub": {
                      "isAvailable": false
                    },
                    "pdf": {
                      "isAvailable": false
                    },
                    "webReaderLink": "http://play.google.com/books/reader?id=AycJAQAAMAAJ&hl=&source=gbs_api",
                    "accessViewStatus": "NONE",
                    "quoteSharingAllowed": false
                  },
                  "searchInfo": {
                    "textSnippet": "The Sixth Edition updates current and ongoing stylistic trends in jazz, including the modern big bands and the new hybrids of jazz extending beyond fusion and crossover."
                  }
                },
                {
                  "kind": "books#volume",
                  "id": "yhY6AQAAIAAJ",
                  "etag": "fHdmmXTkfOU",
                  "selfLink": "https://www.googleapis.com/books/v1/volumes/yhY6AQAAIAAJ",
                  "volumeInfo": {
                    "title": "Jazz Styles",
                    "authors": [
                      "Mark C. Gridley"
                    ],
                    "publisher": "Englewood Cliffs, N.J. : Prentice-Hall",
                    "publishedDate": "1978",
                    "description": "America's most popular introduction to jazz-now with MyMusicLab For undergraduate courses in Jazz History, Jazz Survey, Evolution of Jazz, Introduction to Jazz, and Jazz Appreciation. America's most widely used introduction to jazz text captures the minds of students by teaching the history of the styles and how to actively listen to jazz. While its chronological format serves as a great resource for beginners, Jazz Styles is applicable to more advanced students because of its in-depth analysis of musical elements and its technical appendices that discuss music theory concepts. This new edition incorporates a rich array of online features--including a full interactive eText, streaming audio, and historic performance video-through MyMusicLab. MyMusicLab was developed to help engage students in course material and assess their understanding of the material. With powerful online learning tools integrated into the book, the online and textbook experience is more seamless than ever before. MyMusicLab provides wonderful interactive resources that the instructor can bring directly into the classroom.Teaching and Learning Experience Personalize Learning- The new MyMusicLab delivers proven results in helping students succeed, provides engaging experiences that personalize learning, and comes from a trusted partner with educational expertise and a deep commitment to helping students and instructors achieve their goals. Improve Active Listening- Jazz Styles is celebrated for its detailed listening guides that take students through the key elements in each performance. Through MyMusicLab, these guides are now integrated with streaming audio for a truly integrated listening experience. Engage Students- In the text, an engaging design, historic photographs, and active listening activities engage students in learning, while streaming audio, historic performances by jazz legends, and a full interactive eText in MyMusicLab engage them online. Support Instructors- Supported by the best instructor resources on the market, including a full Instructor's Manual, Testbank, MyMusicLab, ClassPrep for digital images.",
                    "industryIdentifiers": [
                      {
                        "type": "OTHER",
                        "identifier": "UCSD:31822011663291"
                      }
                    ],
                    "readingModes": {
                      "text": false,
                      "image": false
                    },
                    "pageCount": 442,
                    "printType": "BOOK",
                    "categories": [
                      "Jazz"
                    ],
                    "maturityRating": "NOT_MATURE",
                    "allowAnonLogging": false,
                    "contentVersion": "0.8.5.0.preview.0",
                    "panelizationSummary": {
                      "containsEpubBubbles": false,
                      "containsImageBubbles": false
                    },
                    "imageLinks": {
                      "smallThumbnail": "http://books.google.com/books/content?id=yhY6AQAAIAAJ&printsec=frontcover&img=1&zoom=5&source=gbs_api",
                      "thumbnail": "http://books.google.com/books/content?id=yhY6AQAAIAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api"
                    },
                    "language": "en",
                    "previewLink": "http://books.google.com.ph/books?id=yhY6AQAAIAAJ&q=jazz+history&dq=jazz+history&hl=&cd=3&source=gbs_api",
                    "infoLink": "http://books.google.com.ph/books?id=yhY6AQAAIAAJ&dq=jazz+history&hl=&source=gbs_api",
                    "canonicalVolumeLink": "https://books.google.com/books/about/Jazz_Styles.html?hl=&id=yhY6AQAAIAAJ"
                  },
                  "saleInfo": {
                    "country": "PH",
                    "saleability": "NOT_FOR_SALE",
                    "isEbook": false
                  },
                  "accessInfo": {
                    "country": "PH",
                    "viewability": "NO_PAGES",
                    "embeddable": false,
                    "publicDomain": false,
                    "textToSpeechPermission": "ALLOWED",
                    "epub": {
                      "isAvailable": false
                    },
                    "pdf": {
                      "isAvailable": false
                    },
                    "webReaderLink": "http://play.google.com/books/reader?id=yhY6AQAAIAAJ&hl=&source=gbs_api",
                    "accessViewStatus": "NONE",
                    "quoteSharingAllowed": false
                  },
                  "searchInfo": {
                    "textSnippet": "Through MyMusicLab, these guides are now integrated with streaming audio for a truly integrated listening experience."
                  }
                },
                {
                  "kind": "books#volume",
                  "id": "ZUiGAgAAQBAJ",
                  "etag": "4k51HN8Bwa8",
                  "selfLink": "https://www.googleapis.com/books/v1/volumes/ZUiGAgAAQBAJ",
                  "volumeInfo": {
                    "title": "Jazz Historiography",
                    "subtitle": "The Story of Jazz History Writing",
                    "authors": [
                      "Daniel Hardie"
                    ],
                    "publisher": "iUniverse",
                    "publishedDate": "2013-12-11",
                    "description": "Jazz has been around for over a hundred years but how much do we know about its history, and how much of what think we know is true? Beginning in the so called Jazz Age of the 1920s jazz history was recounted and interpreted by admiring authors and record collectors both in the United States and elsewhere. However, since the early 1990s some historians have come to doubt the validity of the conventional narrative of the story of jazz and some of its most hallowed traditions. In Jazz Historiography: The Story of Jazz History Writing Daniel Hardie uncovers the course of jazz history writing from early Jazz Age American and French publications to Academic texts in the 2000s, and seeks answers to questions about the accuracy of those accounts and the influence they have had on our understanding of jazz history - even the impact they might have had on the course of jazz history itself. How much for example did the work of jazz historians influence the course of the New Orleans Revival? Was the appearance of bebop in the 1940s a revolutionary response to oppression experienced by Afro American musicians in a commercialized popular music industry, or was it an attempt to mirror the development of classical music of the time? How has the development of University jazz studies influenced the writing of jazz history?",
                    "industryIdentifiers": [
                      {
                        "type": "ISBN_13",
                        "identifier": "9781491714447"
                      },
                      {
                        "type": "ISBN_10",
                        "identifier": "1491714441"
                      }
                    ],
                    "readingModes": {
                      "text": true,
                      "image": true
                    },
                    "pageCount": 487,
                    "printType": "BOOK",
                    "categories": [
                      "Music"
                    ],
                    "maturityRating": "NOT_MATURE",
                    "allowAnonLogging": true,
                    "contentVersion": "1.4.3.0.preview.3",
                    "panelizationSummary": {
                      "containsEpubBubbles": false,
                      "containsImageBubbles": false
                    },
                    "imageLinks": {
                      "smallThumbnail": "http://books.google.com/books/content?id=ZUiGAgAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api",
                      "thumbnail": "http://books.google.com/books/content?id=ZUiGAgAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"
                    },
                    "language": "en",
                    "previewLink": "http://books.google.com.ph/books?id=ZUiGAgAAQBAJ&printsec=frontcover&dq=jazz+history&hl=&cd=4&source=gbs_api",
                    "infoLink": "http://books.google.com.ph/books?id=ZUiGAgAAQBAJ&dq=jazz+history&hl=&source=gbs_api",
                    "canonicalVolumeLink": "https://books.google.com/books/about/Jazz_Historiography.html?hl=&id=ZUiGAgAAQBAJ"
                  },
                  "saleInfo": {
                    "country": "PH",
                    "saleability": "NOT_FOR_SALE",
                    "isEbook": false
                  },
                  "accessInfo": {
                    "country": "PH",
                    "viewability": "PARTIAL",
                    "embeddable": true,
                    "publicDomain": false,
                    "textToSpeechPermission": "ALLOWED",
                    "epub": {
                      "isAvailable": true,
                      "acsTokenLink": "http://books.google.com.ph/books/download/Jazz_Historiography-sample-epub.acsm?id=ZUiGAgAAQBAJ&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api"
                    },
                    "pdf": {
                      "isAvailable": true,
                      "acsTokenLink": "http://books.google.com.ph/books/download/Jazz_Historiography-sample-pdf.acsm?id=ZUiGAgAAQBAJ&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api"
                    },
                    "webReaderLink": "http://play.google.com/books/reader?id=ZUiGAgAAQBAJ&hl=&source=gbs_api",
                    "accessViewStatus": "SAMPLE",
                    "quoteSharingAllowed": false
                  },
                  "searchInfo": {
                    "textSnippet": "In Jazz Historiography: The Story of Jazz History Writing Daniel Hardie uncovers the course of jazz history writing from early Jazz Age American and French publications to Academic texts in the 2000s, and seeks answers to questions about ..."
                  }
                },
                {
                  "kind": "books#volume",
                  "id": "HS8YAQAAIAAJ",
                  "etag": "9C4z9gRlcvU",
                  "selfLink": "https://www.googleapis.com/books/v1/volumes/HS8YAQAAIAAJ",
                  "volumeInfo": {
                    "title": "Jazz Styles",
                    "subtitle": "History & Analysis",
                    "authors": [
                      "Mark C. Gridley"
                    ],
                    "publishedDate": "2000",
                    "description": "Key Benefit: This broad and encompassing survey provides a rich, informative, and chronological study of jazz, with insightful commentaries on its origins, and full descriptions of the various styles of jazz and the personalities that have contributed to this innovative form of music. Key Topics: Discussions of benchmark styles with point-by-point differentiation cover early jazz, swing, bop, hard bop, cool jazz, \"free\" jazz, and jazz-rock fusion--highlighting the musical characteristics of each style and contrasting each successive era. Market: For musicians and non-musicians alike--to increase their appreciation and enjoyment of jazz.",
                    "industryIdentifiers": [
                      {
                        "type": "OTHER",
                        "identifier": "STANFORD:36105021964437"
                      }
                    ],
                    "readingModes": {
                      "text": false,
                      "image": false
                    },
                    "pageCount": 496,
                    "printType": "BOOK",
                    "categories": [
                      "Music"
                    ],
                    "maturityRating": "NOT_MATURE",
                    "allowAnonLogging": false,
                    "contentVersion": "0.5.2.0.preview.0",
                    "panelizationSummary": {
                      "containsEpubBubbles": false,
                      "containsImageBubbles": false
                    },
                    "imageLinks": {
                      "smallThumbnail": "http://books.google.com/books/content?id=HS8YAQAAIAAJ&printsec=frontcover&img=1&zoom=5&source=gbs_api",
                      "thumbnail": "http://books.google.com/books/content?id=HS8YAQAAIAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api"
                    },
                    "language": "en",
                    "previewLink": "http://books.google.com.ph/books?id=HS8YAQAAIAAJ&q=jazz+history&dq=jazz+history&hl=&cd=5&source=gbs_api",
                    "infoLink": "http://books.google.com.ph/books?id=HS8YAQAAIAAJ&dq=jazz+history&hl=&source=gbs_api",
                    "canonicalVolumeLink": "https://books.google.com/books/about/Jazz_Styles.html?hl=&id=HS8YAQAAIAAJ"
                  },
                  "saleInfo": {
                    "country": "PH",
                    "saleability": "NOT_FOR_SALE",
                    "isEbook": false
                  },
                  "accessInfo": {
                    "country": "PH",
                    "viewability": "NO_PAGES",
                    "embeddable": false,
                    "publicDomain": false,
                    "textToSpeechPermission": "ALLOWED",
                    "epub": {
                      "isAvailable": false
                    },
                    "pdf": {
                      "isAvailable": false
                    },
                    "webReaderLink": "http://play.google.com/books/reader?id=HS8YAQAAIAAJ&hl=&source=gbs_api",
                    "accessViewStatus": "NONE",
                    "quoteSharingAllowed": false
                  },
                  "searchInfo": {
                    "textSnippet": "Key Benefit: This broad and encompassing survey provides a rich, informative, and chronological study of jazz, with insightful commentaries on its origins, and full descriptions of the various styles of jazz and the personalities that have ..."
                  }
                },
                {
                  "kind": "books#volume",
                  "id": "IKwUQQAACAAJ",
                  "etag": "DZQ+Uaemx+4",
                  "selfLink": "https://www.googleapis.com/books/v1/volumes/IKwUQQAACAAJ",
                  "volumeInfo": {
                    "title": "Jazz",
                    "subtitle": "A History",
                    "authors": [
                      "Frank Tirro"
                    ],
                    "publisher": "W. W. Norton",
                    "publishedDate": "1977",
                    "description": "Jazz is a democratic music in the best sense of the word, for it is the collective achievement of a people.",
                    "industryIdentifiers": [
                      {
                        "type": "ISBN_10",
                        "identifier": "0393090787"
                      },
                      {
                        "type": "ISBN_13",
                        "identifier": "9780393090789"
                      }
                    ],
                    "readingModes": {
                      "text": false,
                      "image": false
                    },
                    "pageCount": 457,
                    "printType": "BOOK",
                    "categories": [
                      "Jazz"
                    ],
                    "maturityRating": "NOT_MATURE",
                    "allowAnonLogging": false,
                    "contentVersion": "preview-1.0.0",
                    "language": "en",
                    "previewLink": "http://books.google.com.ph/books?id=IKwUQQAACAAJ&dq=jazz+history&hl=&cd=6&source=gbs_api",
                    "infoLink": "http://books.google.com.ph/books?id=IKwUQQAACAAJ&dq=jazz+history&hl=&source=gbs_api",
                    "canonicalVolumeLink": "https://books.google.com/books/about/Jazz.html?hl=&id=IKwUQQAACAAJ"
                  },
                  "saleInfo": {
                    "country": "PH",
                    "saleability": "NOT_FOR_SALE",
                    "isEbook": false
                  },
                  "accessInfo": {
                    "country": "PH",
                    "viewability": "NO_PAGES",
                    "embeddable": false,
                    "publicDomain": false,
                    "textToSpeechPermission": "ALLOWED",
                    "epub": {
                      "isAvailable": false
                    },
                    "pdf": {
                      "isAvailable": false
                    },
                    "webReaderLink": "http://play.google.com/books/reader?id=IKwUQQAACAAJ&hl=&source=gbs_api",
                    "accessViewStatus": "NONE",
                    "quoteSharingAllowed": false
                  },
                  "searchInfo": {
                    "textSnippet": "Jazz is a democratic music in the best sense of the word, for it is the collective achievement of a people."
                  }
                },
                {
                  "kind": "books#volume",
                  "id": "Xj0JAAAACAAJ",
                  "etag": "0QJ6gGiAWto",
                  "selfLink": "https://www.googleapis.com/books/v1/volumes/Xj0JAAAACAAJ",
                  "volumeInfo": {
                    "title": "Jazz-Rock",
                    "subtitle": "A History",
                    "authors": [
                      "Stuart Nicholson"
                    ],
                    "publisher": "Schirmer Trade Books",
                    "publishedDate": "2000-12-22",
                    "description": "The quintessential crossover form, jazz-rock encompasses the most popular hybrid styles, from 1970s fusion to the latest in acid jazz. Jazz-Rock: A History provides a clear overview of the many trends and musical genres that comprise this popular music.",
                    "industryIdentifiers": [
                      {
                        "type": "ISBN_10",
                        "identifier": "0825671884"
                      },
                      {
                        "type": "ISBN_13",
                        "identifier": "9780825671883"
                      }
                    ],
                    "readingModes": {
                      "text": false,
                      "image": false
                    },
                    "pageCount": 0,
                    "printType": "BOOK",
                    "categories": [
                      "Jazz"
                    ],
                    "maturityRating": "NOT_MATURE",
                    "allowAnonLogging": false,
                    "contentVersion": "preview-1.0.0",
                    "panelizationSummary": {
                      "containsEpubBubbles": false,
                      "containsImageBubbles": false
                    },
                    "imageLinks": {
                      "smallThumbnail": "http://books.google.com/books/content?id=Xj0JAAAACAAJ&printsec=frontcover&img=1&zoom=5&source=gbs_api",
                      "thumbnail": "http://books.google.com/books/content?id=Xj0JAAAACAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api"
                    },
                    "language": "en",
                    "previewLink": "http://books.google.com.ph/books?id=Xj0JAAAACAAJ&dq=jazz+history&hl=&cd=7&source=gbs_api",
                    "infoLink": "http://books.google.com.ph/books?id=Xj0JAAAACAAJ&dq=jazz+history&hl=&source=gbs_api",
                    "canonicalVolumeLink": "https://books.google.com/books/about/Jazz_Rock.html?hl=&id=Xj0JAAAACAAJ"
                  },
                  "saleInfo": {
                    "country": "PH",
                    "saleability": "NOT_FOR_SALE",
                    "isEbook": false
                  },
                  "accessInfo": {
                    "country": "PH",
                    "viewability": "NO_PAGES",
                    "embeddable": false,
                    "publicDomain": false,
                    "textToSpeechPermission": "ALLOWED",
                    "epub": {
                      "isAvailable": false
                    },
                    "pdf": {
                      "isAvailable": false
                    },
                    "webReaderLink": "http://play.google.com/books/reader?id=Xj0JAAAACAAJ&hl=&source=gbs_api",
                    "accessViewStatus": "NONE",
                    "quoteSharingAllowed": false
                  },
                  "searchInfo": {
                    "textSnippet": "The quintessential crossover form, jazz-rock encompasses the most popular hybrid styles, from 1970s fusion to the latest in acid jazz."
                  }
                },
                {
                  "kind": "books#volume",
                  "id": "PIlmDwAAQBAJ",
                  "etag": "L3xmGozgUEI",
                  "selfLink": "https://www.googleapis.com/books/v1/volumes/PIlmDwAAQBAJ",
                  "volumeInfo": {
                    "title": "The History of Jazz",
                    "authors": [
                      "Stuart A. Kallen"
                    ],
                    "publisher": "Greenhaven Publishing LLC",
                    "publishedDate": "2012-06-22",
                    "description": "Readers will learn that music based on jazz beats can be heard all over the world but the roots of the style are distinctly American. Jazz grew out of the musical hothouse that was New Orleans, Louisiana at the end of the nineteenth century. Jazz represents the creative musical side of the United States to people across the globe. Jazz personalities such as Louis Armstrong, Dizzy Gillespie, Wynton Marsalis, and now Esperanza Spaulding, are heroes to countless jazz fans from Tokyo to Paris to Rio de Janeiro. Just as a swinging jazz quartet unites its individual players behind a driving syncopated beat, jazz music has proven its ability to bring people together over a shared interest in a universal sound.",
                    "industryIdentifiers": [
                      {
                        "type": "ISBN_13",
                        "identifier": "9781420508208"
                      },
                      {
                        "type": "ISBN_10",
                        "identifier": "1420508202"
                      }
                    ],
                    "readingModes": {
                      "text": false,
                      "image": true
                    },
                    "pageCount": 130,
                    "printType": "BOOK",
                    "categories": [
                      "Young Adult Nonfiction"
                    ],
                    "maturityRating": "NOT_MATURE",
                    "allowAnonLogging": false,
                    "contentVersion": "0.1.1.0.preview.1",
                    "panelizationSummary": {
                      "containsEpubBubbles": false,
                      "containsImageBubbles": false
                    },
                    "imageLinks": {
                      "smallThumbnail": "http://books.google.com/books/content?id=PIlmDwAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api",
                      "thumbnail": "http://books.google.com/books/content?id=PIlmDwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"
                    },
                    "language": "en",
                    "previewLink": "http://books.google.com.ph/books?id=PIlmDwAAQBAJ&printsec=frontcover&dq=jazz+history&hl=&cd=8&source=gbs_api",
                    "infoLink": "http://books.google.com.ph/books?id=PIlmDwAAQBAJ&dq=jazz+history&hl=&source=gbs_api",
                    "canonicalVolumeLink": "https://books.google.com/books/about/The_History_of_Jazz.html?hl=&id=PIlmDwAAQBAJ"
                  },
                  "saleInfo": {
                    "country": "PH",
                    "saleability": "NOT_FOR_SALE",
                    "isEbook": false
                  },
                  "accessInfo": {
                    "country": "PH",
                    "viewability": "PARTIAL",
                    "embeddable": true,
                    "publicDomain": false,
                    "textToSpeechPermission": "ALLOWED",
                    "epub": {
                      "isAvailable": false
                    },
                    "pdf": {
                      "isAvailable": true,
                      "acsTokenLink": "http://books.google.com.ph/books/download/The_History_of_Jazz-sample-pdf.acsm?id=PIlmDwAAQBAJ&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api"
                    },
                    "webReaderLink": "http://play.google.com/books/reader?id=PIlmDwAAQBAJ&hl=&source=gbs_api",
                    "accessViewStatus": "SAMPLE",
                    "quoteSharingAllowed": false
                  },
                  "searchInfo": {
                    "textSnippet": "Readers will learn that music based on jazz beats can be heard all over the world but the roots of the style are distinctly American."
                  }
                },
                {
                  "kind": "books#volume",
                  "id": "oGp6QgAACAAJ",
                  "etag": "2/joQ+UevbA",
                  "selfLink": "https://www.googleapis.com/books/v1/volumes/oGp6QgAACAAJ",
                  "volumeInfo": {
                    "title": "New History of Jazz",
                    "authors": [
                      "Alyn Shipton"
                    ],
                    "publisher": "Bloomsbury Academic",
                    "publishedDate": "2004-03-30",
                    "description": "In this major update of the acclaimed and award-winning jazz history, Alyn Shipton challenges many of the assumptions that surround the birth and growth of jazz music. Shipton also re-evaluates the transition from swing to be-bop, asking just how political this supposed modern jazz revolution actually was. He makes the case for jazz as a truly international music from its earliest days, charting significant developments outside the USA from the 1920s onwards. All the great names in jazz history are here, from Louis Armstrong to Miles Davis and from Sidney Bechet to Charlie Parker and John Coltrane. But unlike those historians who call a halt with the death of Coltrane in 1967, Shipton continues the story with the major trends in jazz over the last 40 years: free jazz, jazz rock, world music influences, and the re-emergence of the popular jazz singer. This new edition brings the book completely up-to-date, including such names as John Medeski, Diana Krall, Django Bates, and Matthias Ruegg. There are also impor¬tant new sections on Latin Jazz and the repertory movement.",
                    "industryIdentifiers": [
                      {
                        "type": "ISBN_10",
                        "identifier": "0826473806"
                      },
                      {
                        "type": "ISBN_13",
                        "identifier": "9780826473806"
                      }
                    ],
                    "readingModes": {
                      "text": false,
                      "image": false
                    },
                    "pageCount": 965,
                    "printType": "BOOK",
                    "categories": [
                      "Social Science"
                    ],
                    "averageRating": 2,
                    "ratingsCount": 1,
                    "maturityRating": "NOT_MATURE",
                    "allowAnonLogging": false,
                    "contentVersion": "preview-1.0.0",
                    "imageLinks": {
                      "smallThumbnail": "http://books.google.com/books/content?id=oGp6QgAACAAJ&printsec=frontcover&img=1&zoom=5&source=gbs_api",
                      "thumbnail": "http://books.google.com/books/content?id=oGp6QgAACAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api"
                    },
                    "language": "en",
                    "previewLink": "http://books.google.com.ph/books?id=oGp6QgAACAAJ&dq=jazz+history&hl=&cd=9&source=gbs_api",
                    "infoLink": "http://books.google.com.ph/books?id=oGp6QgAACAAJ&dq=jazz+history&hl=&source=gbs_api",
                    "canonicalVolumeLink": "https://books.google.com/books/about/New_History_of_Jazz.html?hl=&id=oGp6QgAACAAJ"
                  },
                  "saleInfo": {
                    "country": "PH",
                    "saleability": "NOT_FOR_SALE",
                    "isEbook": false
                  },
                  "accessInfo": {
                    "country": "PH",
                    "viewability": "NO_PAGES",
                    "embeddable": false,
                    "publicDomain": false,
                    "textToSpeechPermission": "ALLOWED",
                    "epub": {
                      "isAvailable": false
                    },
                    "pdf": {
                      "isAvailable": false
                    },
                    "webReaderLink": "http://play.google.com/books/reader?id=oGp6QgAACAAJ&hl=&source=gbs_api",
                    "accessViewStatus": "NONE",
                    "quoteSharingAllowed": false
                  },
                  "searchInfo": {
                    "textSnippet": "This new edition brings the book completely up-to-date, including such names as John Medeski, Diana Krall, Django Bates, and Matthias Ruegg. There are also impor¬tant new sections on Latin Jazz and the repertory movement."
                  }
                },
                {
                  "kind": "books#volume",
                  "id": "z_-cAQAACAAJ",
                  "etag": "pUgIBOzDvcc",
                  "selfLink": "https://www.googleapis.com/books/v1/volumes/z_-cAQAACAAJ",
                  "volumeInfo": {
                    "title": "The History of European Jazz",
                    "subtitle": "The Music, Musicians and Audience in Context",
                    "authors": [
                      "Francesco Martinelli"
                    ],
                    "publisher": "Popular Music History",
                    "publishedDate": "2018",
                    "description": "As the first organic overview of the history of jazz in Europe and covering the subject from its inception to the present day, the volume provides a unique, authoritative addition to the musicological literature.",
                    "industryIdentifiers": [
                      {
                        "type": "ISBN_10",
                        "identifier": "1781794464"
                      },
                      {
                        "type": "ISBN_13",
                        "identifier": "9781781794463"
                      }
                    ],
                    "readingModes": {
                      "text": false,
                      "image": false
                    },
                    "pageCount": 0,
                    "printType": "BOOK",
                    "categories": [
                      "Music"
                    ],
                    "maturityRating": "NOT_MATURE",
                    "allowAnonLogging": false,
                    "contentVersion": "preview-1.0.0",
                    "panelizationSummary": {
                      "containsEpubBubbles": false,
                      "containsImageBubbles": false
                    },
                    "imageLinks": {
                      "smallThumbnail": "http://books.google.com/books/content?id=z_-cAQAACAAJ&printsec=frontcover&img=1&zoom=5&source=gbs_api",
                      "thumbnail": "http://books.google.com/books/content?id=z_-cAQAACAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api"
                    },
                    "language": "en",
                    "previewLink": "http://books.google.com.ph/books?id=z_-cAQAACAAJ&dq=jazz+history&hl=&cd=10&source=gbs_api",
                    "infoLink": "http://books.google.com.ph/books?id=z_-cAQAACAAJ&dq=jazz+history&hl=&source=gbs_api",
                    "canonicalVolumeLink": "https://books.google.com/books/about/The_History_of_European_Jazz.html?hl=&id=z_-cAQAACAAJ"
                  },
                  "saleInfo": {
                    "country": "PH",
                    "saleability": "NOT_FOR_SALE",
                    "isEbook": false
                  },
                  "accessInfo": {
                    "country": "PH",
                    "viewability": "NO_PAGES",
                    "embeddable": false,
                    "publicDomain": false,
                    "textToSpeechPermission": "ALLOWED",
                    "epub": {
                      "isAvailable": false
                    },
                    "pdf": {
                      "isAvailable": false
                    },
                    "webReaderLink": "http://play.google.com/books/reader?id=z_-cAQAACAAJ&hl=&source=gbs_api",
                    "accessViewStatus": "NONE",
                    "quoteSharingAllowed": false
                  },
                  "searchInfo": {
                    "textSnippet": "As the first organic overview of the history of jazz in Europe and covering the subject from its inception to the present day, the volume provides a unique, authoritative addition to the musicological literature."
                  }
                }
              ]
            }
        """.trimIndent())

        val targetBook = bookShelf.books[1]

        assertEquals("Introduction to Jazz History", targetBook.info.title)
    }
}