#If the book is returned on or before the expected return date, no fine will be charged (i.e.: fine=0)fine=0).
#If the book is returned after the expected return day but still within the same calendar month and year as the expected return #date, fine=15 Hackos × (the number of days late)fine=15 Hackos × (the number of days late).
#If the book is returned after the expected return month but still within the same calendar year as the expected return date, the #fine=500 Hackos × (the number of months late)fine=500 Hackos × (the number of months late).
#If the book is returned after the calendar year in which it was expected, there is a fixed fine of 10000 Hackos10000 Hackos.

my $a = <>; chomp $a;
my $b = <>; chomp $b;

my ($d1, $m1, $y1) = split / /, $b;
my ($d2, $m2, $y2) = split / /, $a;

my $fine;

if ($y2<$y1) {
    $fine=0;
} elsif ($y2==$y1) {
        if ($m2==$m1) {
            if ($d2<=$d1) {
                $fine=0;
            } else {
                $fine=15*($d2-$d1);
            }
        } elsif ($m2<=$m1) {
                $fine=0;
            } else {
                $fine=500*($m2-$m1)
            }
    } else {
        $fine=10000;
    }

print "$fine";
