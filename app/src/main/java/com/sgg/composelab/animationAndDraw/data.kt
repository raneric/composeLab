package com.sgg.composelab.animationAndDraw

data class Sales(
        val year: Int,
        val amount: Float
)

data class PathPoint(
        var x: Float=0f,
        var y: Float=0f
)

val fakeDataList = listOf(
        Sales(1999, 550f * 1000),
        Sales(2000, 412f * 1000),
        Sales(2001, 320f * 1000),
        Sales(2002, 650f * 1000),
        Sales(2004, 800f * 1000),
        Sales(2003, 986f * 1000),
        Sales(2005, 830f * 1000),
        Sales(2008, 1200f * 1000),
        Sales(2007, 1390f * 1000),
        Sales(2008, 1500f * 1000),
        Sales(2009, 1358f * 1000),
        Sales(2010, 1550f * 1000),
        Sales(2011, 1660f * 1000),
        Sales(2012, 2000f * 1000),
        Sales(2013, 2036f * 1000),
        Sales(2014, 2500f * 1000),
        Sales(2015, 1700f * 1000),
        Sales(2016, 1893f * 1000),
        Sales(2017, 2598f * 1000),
        Sales(2018, 2750f * 1000),
        Sales(2019, 3000f * 1000),
        Sales(2020, 3250f * 1000),
        Sales(2021, 3600f * 1000),
        Sales(2022, 3500f * 1000),
        Sales(2023, 3700f * 1000),
        Sales(2024, 3600f * 1000),
)


