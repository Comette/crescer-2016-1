﻿using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace CdZ.MVC.CustomModelBinders
{
    public class DoubleModelBinder : DefaultModelBinder
    {
        #region Implementation of IModelBinder

        public override object BindModel(ControllerContext controllerContext, ModelBindingContext bindingContext)
        {
            var result = bindingContext.ValueProvider.GetValue(bindingContext.ModelName);
            if (result != null && !string.IsNullOrEmpty(result.AttemptedValue))
            {
                if (bindingContext.ModelType == typeof(double))
                {
                    double temp;
                    var attempted = result.AttemptedValue.Replace(",", ".");
                    if (double.TryParse(attempted, NumberStyles.Number, CultureInfo.InvariantCulture, out temp)
                    )
                    {
                        return temp;
                    }
                }
            }
            return base.BindModel(controllerContext, bindingContext);
        }

        #endregion
    }
}