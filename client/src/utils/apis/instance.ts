import axios from 'axios';

const SERVER_BASE_URL = import.meta.env.VITE_APP_SERVER_BASE_URL;

export const instance = axios.create({
	baseURL: SERVER_BASE_URL,
	headers: {
		'Access-Control-Allow-Origin': '*',
		'Content-Type': 'application/json',
	},
});
