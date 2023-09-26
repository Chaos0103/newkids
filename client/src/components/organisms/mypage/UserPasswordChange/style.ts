import styled from 'styled-components';

export const UserPasswordChangeContainer = styled.div`
	.change-password-form {
		width: 100%;
		height: 100%;
		gap: 3rem;

		.password-input {
			display: flex;
			justify-content: center;
			margin-bottom: 2rem;
		}

		.change-password-title {
			margin-bottom: 3rem;
			display: flex;
			justify-content: center;
			align-items: center;

			svg {
				height: 70px;
				width: 60px;
			}
			.danger-color {
				color: var(--danger-color);
				font-size: 30px;
				font-weight: bold;
			}
			.black-color {
				color: var(--gray-500);
				font-size: 30px;
			}
			.bold-black-color {
				color: var(--gray-500);
				font-size: 30px;
				font-weight: bold;
			}
		}
		.password-button {
			width: 100%;
			display: flex;
			justify-content: center;
			gap: 20px;
			.button-container {
				width: 80%;
				display: flex;
				gap: 15px;
			}
		}
	}
`;
