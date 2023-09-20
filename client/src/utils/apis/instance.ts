import axios from 'axios';

export const instance = axios.create({
	baseURL: '/api/',
	headers: {
		'Access-Control-Allow-Origin': '*',
		'Content-Type': 'application/json',
	},
});
