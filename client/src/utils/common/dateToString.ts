import moment from 'moment';

export const dateToString = (date: Date): string => {
	return moment(date).format('YYYY-MM-DD');
};
