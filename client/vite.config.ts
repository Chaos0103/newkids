import { defineConfig } from 'vite';
import react from '@vitejs/plugin-react';
import eslint from 'vite-plugin-eslint';
import tsconfigPaths from 'vite-tsconfig-paths';
import svgr from 'vite-plugin-svgr';

// TODO : froxy 설정 시, url 숨기기(.env)
export default defineConfig({
	plugins: [react(), eslint(), tsconfigPaths(), svgr()],
	base: '/index',
	server: {
		proxy: {
			'/api': {
				target: 'https://j9c205.p.ssafy.io',
				changeOrigin: true,
				rewrite: (path) => path.replace(/%\/api/, ''),
				secure: false,
				ws: true,
			},
		},
	},
});
