/* This file was generated by SableCC (http://www.sablecc.org/). */

package cps450.oodle.node;

import cps450.oodle.analysis.*;

@SuppressWarnings("nls")
public final class AVarAssign extends PVarAssign
{
    private TAsignOp _asignOp_;
    private PExpression _expression_;

    public AVarAssign()
    {
        // Constructor
    }

    public AVarAssign(
        @SuppressWarnings("hiding") TAsignOp _asignOp_,
        @SuppressWarnings("hiding") PExpression _expression_)
    {
        // Constructor
        setAsignOp(_asignOp_);

        setExpression(_expression_);

    }

    @Override
    public Object clone()
    {
        return new AVarAssign(
            cloneNode(this._asignOp_),
            cloneNode(this._expression_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAVarAssign(this);
    }

    public TAsignOp getAsignOp()
    {
        return this._asignOp_;
    }

    public void setAsignOp(TAsignOp node)
    {
        if(this._asignOp_ != null)
        {
            this._asignOp_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._asignOp_ = node;
    }

    public PExpression getExpression()
    {
        return this._expression_;
    }

    public void setExpression(PExpression node)
    {
        if(this._expression_ != null)
        {
            this._expression_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expression_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._asignOp_)
            + toString(this._expression_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._asignOp_ == child)
        {
            this._asignOp_ = null;
            return;
        }

        if(this._expression_ == child)
        {
            this._expression_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._asignOp_ == oldChild)
        {
            setAsignOp((TAsignOp) newChild);
            return;
        }

        if(this._expression_ == oldChild)
        {
            setExpression((PExpression) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}