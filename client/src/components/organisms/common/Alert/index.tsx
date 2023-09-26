import React, { Dispatch, SetStateAction } from 'react';
import axios from 'axios';
import Swal from 'sweetalert2';
import Button from 'components/atoms/common/Button';
import { AlertContainer } from './style';

interface IAlertProps {
	setStep: Dispatch<SetStateAction<number>>;
	setStage: Dispatch<SetStateAction<number>>;
	setNum: Dispatch<SetStateAction<number>>;
	imageUrls: string;
	imageHeights: number;
	titles: string;
	confirms: string;
	colors: string;
	num: number;
}

function Alert(props: IAlertProps) {
	const { setStage, setStep, setNum, imageUrls, imageHeights, titles, confirms, colors, num } = props;

	const alert = () =>
		axios.get(`//api.github.com/users/bandozen`).then(() => {
			Swal.fire({
				imageUrl: imageUrls,
				imageHeight: imageHeights,
				title: titles,
				confirmButtonColor: colors,
				confirmButtonText: confirms,
			}).then(() => {
				if (num === 0) {
					setNum(1);
					setStage(1);
					setStep(2);
				} else if (num === 1) {
					setNum(2);
					setStage(2);
					setStep(2);
				} else if (num === 2) {
					setNum(3);
					setStage(3);
					setStep(2);
				} else if (num === 3) {
					setStage(4);
				}
			});
		});
	return (
		<AlertContainer>
			<Button size="s" radius="m" color="Primary" text="제출" handleClick={alert} />
		</AlertContainer>
	);
}

export default Alert;
