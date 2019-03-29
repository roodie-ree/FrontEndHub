const daysOfTheWeek = {
  Sunday: 0,
  Monday: 1,
  Tuesday: 2,
  Wednesday: 3,
  Thursday: 4,
  Friday: 5,
  Saturday: 6,
};

function meetupDay(year, month, dow, wom) {
  const dayOfWeek = daysOfTheWeek[dow];
  const weekOfMonth = Number.parseInt(wom[0], 10);
  const firstDayOfMonth = new Date(year, month, 1);
  const firstWeekday = firstDayOfMonth.getDay();
  if (firstWeekday <= dayOfWeek) {
    firstDayOfMonth.setDate(dayOfWeek - firstWeekday + 1);
  } else {
    firstDayOfMonth.setDate(dayOfWeek - firstWeekday + 8);
  }
  const dayOfMonth = firstDayOfMonth.getDate();
  if (Number.isInteger(weekOfMonth)) {
    firstDayOfMonth.setDate(dayOfMonth + (weekOfMonth - 1) * 7);
    if (firstDayOfMonth.getMonth() !== month) {
      throw new Error();
    }
  } else if (wom === 'teenth') {
    if (dayOfMonth > 5) {
      firstDayOfMonth.setDate(dayOfMonth + 7);
    } else {
      firstDayOfMonth.setDate(dayOfMonth + 14);
    }
  } else if (wom === 'last') {
    firstDayOfMonth.setDate(dayOfMonth + 28);
    if (firstDayOfMonth.getMonth() !== month) {
      firstDayOfMonth.setDate(firstDayOfMonth.getDate() - 7);
    }
  }

  return firstDayOfMonth;
}

export { meetupDay };
